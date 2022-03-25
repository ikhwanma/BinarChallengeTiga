package ikhwan.binar.challengechaptertiga

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataUser(
    val nama: String?,
    val usia: String?,
    val alamat: String?,
    val pekerjaan: String?
) : Parcelable
