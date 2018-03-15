package pablokintopp.com.mvvmtemplate.model.api.entity;

import org.parceler.Parcel;

/**
 * Created by Pablo on 14/03/2018.
 */
@Parcel
public class Repo {
    public int id;
    public String name;
    public String url;
    public User owner;
    public String description;

}
