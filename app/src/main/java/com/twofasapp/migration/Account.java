package com.twofasapp.migration;

import android.net.Uri;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.Sort;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mrauter on 28.02.18.
 */

public class Account extends RealmObject {

    @PrimaryKey
    private String id = UUID.randomUUID().toString();
    private String secret;
    private String issuer;
    private String username;
    private int digits = 6;
    private int period = 30;
    private Boolean engine = false;
    private Date created = new Date();

    @Ignore
    private Boolean selected = false;

    public Account() {

    }

    public Account(String secret, String issuer, String username, int digits, int period, Boolean engine) {
        this.secret = secret;
        this.issuer = issuer;
        this.username = username;
        this.digits = digits;
        this.period = period;
        this.engine = engine;
    }

    public static List<Account> readAllFromRealm() {
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<Account> query = realm.where(Account.class);
        RealmResults<Account> results = query.findAll().sort("created", Sort.ASCENDING);
        if (results != null) {
            return realm.copyFromRealm(results);
        }
        return null;
    }

    public static void writeToRealm(Account account) {
        if (account != null) {
            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();
            realm.copyToRealm(account);
            realm.commitTransaction();
        }
    }

    public static void deleteFromRealm(Account account) {
        if (account != null) {
            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();
            Account result = realm.where(Account.class).equalTo("id", account.getId()).findFirst();
            if(result != null) {
                result.deleteFromRealm();
            }
            realm.commitTransaction();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public int getDigits() {
        return digits;
    }

    public void setDigits(int digits) {
        this.digits = digits;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public Boolean getEngine() {
        return engine;
    }

    public void setEngine(Boolean engine) {
        this.engine = engine;
    }
}
