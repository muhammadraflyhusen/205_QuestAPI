package com.example.restapi2.uicontroller.route

object DestinasiDetail : DestinasiNavigasi {
    override val route = "item_detail"
    override val titleRes = R.string.detail_siswa
    const val siswaIdArg = "id"
    val routeWithArgs = "$route/{$siswaIdArg}"
}