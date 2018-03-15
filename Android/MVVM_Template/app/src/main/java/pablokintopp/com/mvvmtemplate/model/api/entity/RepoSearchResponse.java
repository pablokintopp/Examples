package pablokintopp.com.mvvmtemplate.model.api.entity;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

/**
 * Created by Pablo on 14/03/2018.
 */
@Parcel
public class RepoSearchResponse {
    @SerializedName("total_count")
    public int totalCount;
    public List<Repo> items;
}
