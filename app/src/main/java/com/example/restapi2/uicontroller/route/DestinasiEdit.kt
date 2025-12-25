package com.example.restapi2.uicontroller.route

object DestinasiEdit : DestinasiNavigasi {
    override val route = "item_edit"
    override val titleRes = R.string.edit_siswa
    const val siswaIdArg = "id"
    val routeWithArgs = "$route/{$siswaIdArg}"
}