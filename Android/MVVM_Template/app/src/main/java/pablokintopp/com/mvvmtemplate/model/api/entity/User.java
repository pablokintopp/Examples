package pablokintopp.com.mvvmtemplate.model.api.entity;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by Pablo Kintopp, Mar 2018.
 */
@Parcel
public class User {
    public String id;
    @SerializedName("login")
    public String username;
    @SerializedName("avatar_url")
    public String profilePicture;
    public String fullname;
    @SerializedName("html_url")
    public String url;
}
