package com.base.projectmovies.batmanlist

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import com.base.projectmovies.remote.BaseResponse
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


@Entity(

    tableName = "movies"
)
data class SearchModel(
    @SerializedName("Title")
    @Expose
    var title: String? = null,
    @SerializedName("Year")
    @Expose
    var year: String? = null,
    @SerializedName("imdbID")
    @Expose
    var imdbID: String? = null,
    @SerializedName("Type")
    @Expose
    var type: String? = null,
    @SerializedName("Poster")
    @Expose
    var poster: String? = null
) : BaseResponse(), Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(year)
        parcel.writeString(imdbID)
        parcel.writeString(type)
        parcel.writeString(poster)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SearchModel> {
        override fun createFromParcel(parcel: Parcel): SearchModel {
            return SearchModel(parcel)
        }

        override fun newArray(size: Int): Array<SearchModel?> {
            return arrayOfNulls(size)
        }
    }


}
