package com.example.aplikasidisastercheck

import com.google.gson.annotations.SerializedName

data class InfoFaskes(
    @SerializedName("id"           ) var id: List<InfoFaskes>?,
    @SerializedName("kode"         ) var kode: String,
    @SerializedName("nama"         ) var nama: String,
    @SerializedName("kota"         ) var kota: String,
    @SerializedName("provinsi"     ) var provinsi: String,
    @SerializedName("alamat"       ) var alamat: String,
    @SerializedName("latitude"     ) var latitude: String,
    @SerializedName("longitude"    ) var longitude: String,
    @SerializedName("telp"         ) var telp: String,
    @SerializedName("jenis_faskes" ) var jenisFaskes: String,
    @SerializedName("kelas_rs"     ) var kelasRs: String,
    @SerializedName("status"       ) var status: String,
    @SerializedName("Detail"       ) var detail: DetailFaskes
)

data class DetailFaskes (
    @SerializedName("id"               ) var id             : Int,
    @SerializedName("kode"             ) var kode           : String,
    @SerializedName("batch"            ) var batch          : String,
    @SerializedName("divaksin"         ) var divaksin       : Int,
    @SerializedName("divaksin_1"       ) var divaksin1      : Int,
    @SerializedName("divaksin_2"       ) var divaksin2      : Int,
    @SerializedName("batal_vaksin"     ) var batalVaksin    : Int,
    @SerializedName("batal_vaksin_1"   ) var batalVaksin1   : Int,
    @SerializedName("batal_vaksin_2"   ) var batalVaksin2   : Int,
    @SerializedName("pending_vaksin"   ) var pendingVaksin  : Int,
    @SerializedName("pending_vaksin_1" ) var pendingVaksin1 : Int,
    @SerializedName("pending_vaksin_2" ) var pendingVaksin2 : Int,
    @SerializedName("tanggal"          ) var tanggal        : String

)