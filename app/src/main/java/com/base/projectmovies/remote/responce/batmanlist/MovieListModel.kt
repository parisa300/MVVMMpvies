package com.base.projectmovies.batmanlist

import android.os.Parcel
import android.os.Parcelable
import com.base.projectmovies.remote.BaseResponse
import com.base.projectmovies.remote.responce.batmanlist.SearchModel


data class MovieListModel(
    var Search: MutableList<SearchModel> = mutableListOf(),
    var totalResults: String? = null,
    var response: String? = null

) : BaseResponse(), Parcelable {
    constructor(parcel: Parcel) : this(
        TODO("Search"),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(totalResults)
        parcel.writeString(response)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieListModel> {
        override fun createFromParcel(parcel: Parcel): MovieListModel {
            return MovieListModel(parcel)
        }

        override fun newArray(size: Int): Array<MovieListModel?> {
            return arrayOfNulls(size)
        }
    }


}
