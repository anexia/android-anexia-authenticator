package com.twofasapp.migration

import android.content.Context
import com.twofasapp.common.domain.BackupSyncStatus
import com.twofasapp.common.domain.Service
import com.twofasapp.common.domain.Service.Algorithm
import com.twofasapp.common.time.TimeProvider
import com.twofasapp.data.services.ServicesRepository
import com.twofasapp.parsers.ServiceIcons
import com.twofasapp.prefs.usecase.MigratedRealmToRoomPreference
import io.realm.Realm
import io.realm.RealmConfiguration

class MigrateRealmToRoom(
    private val context: Context,
    private val servicesRepository: ServicesRepository,
    private val migratedRealmToRoomPreference: MigratedRealmToRoomPreference,
    private val timeProvider: TimeProvider,
) {

    suspend fun invoke() {
        try {
            if (migratedRealmToRoomPreference.get()) {
                return
            }

            if (context.filesDir?.list()?.contains("default.realm") == false) {
                return
            }

            val oldAccounts = getDataFromRealmDb()
            val now = timeProvider.systemCurrentTime()

            servicesRepository.addServices(
                oldAccounts.map {
                    Service(
                        id = 0,
                        name = it.issuer,
                        secret = it.secret,
                        authType = com.twofasapp.common.domain.Service.AuthType.TOTP,
                        backupSyncStatus = BackupSyncStatus.NOT_SYNCED,
                        updatedAt = now,
                        assignedDomains = emptyList(),
                        serviceTypeId = null,
                        iconCollectionId = ServiceIcons.defaultCollectionId,
                        imageType = Service.ImageType.Label,
                        labelText = it.issuer.take(2).uppercase(),
                        source = com.twofasapp.common.domain.Service.Source.Manual,
                        info = it.username,
                        link = null,
                        issuer = it.issuer,
                        period = it.period,
                        digits = it.digits,
                        algorithm = Algorithm.SHA1,
                        iconLight = "",
                        iconDark = "",
                        badgeColor = null,
                        tags = listOf(),
                        isDeleted = false,
                    )
                }
            )

            val roomServices = servicesRepository.getServices()
            val isSuccess = roomServices.map { it.secret.lowercase().trim() }.distinct()
                .containsAll(oldAccounts.map { it.secret.lowercase().trim() }.distinct())
            migratedRealmToRoomPreference.put(isSuccess)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun getDataFromRealmDb(): List<Account> {
        Realm.init(context)
        val config = RealmConfiguration.Builder().schemaVersion(1).build()
        Realm.setDefaultConfiguration(config)

        val accounts = Account.readAllFromRealm()
        accounts.forEach { account ->
            if (account.issuer == null) {
                account.issuer = account.username
                account.username = ""
            }
        }
        return accounts
    }
}