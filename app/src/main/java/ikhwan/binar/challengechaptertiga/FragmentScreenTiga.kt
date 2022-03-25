package ikhwan.binar.challengechaptertiga

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_screen_tiga.*

class FragmentScreenTiga : Fragment() {

    private lateinit var nama: String
    private lateinit var usia: String
    private lateinit var alamat: String
    private lateinit var pekerjaan: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_screen_tiga,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userData = arguments?.getParcelable<DataUser>(EXTRA_DATA) as DataUser

        nama = userData.nama.toString()
        usia = userData.usia.toString()
        alamat = userData.alamat.toString()
        pekerjaan = userData.pekerjaan.toString()

        cekData()
        openEmpat()
    }

    private fun openEmpat() {
        btn_empat.setOnClickListener{
            val dataUser = DataUser(nama, usia, alamat, pekerjaan)
            val mBundle = bundleOf(EXTRA_DATA to dataUser)
            it.findNavController()
                .navigate(R.id.action_fragmentScreenTiga_to_fragmentScreenEmpat, mBundle)
        }
    }

    private fun cekData() {
        if (usia == "null") {
            onlyName()
        } else {
            fullData()
        }
    }

    private fun fullData() {
        val textUsia = if (usia != "") {
            cekUsia(usia.toInt())
        } else {
            ""
        }

        tv_namaDua.text = ""
        tv_nama.text = nama
        tv_usia.text = textUsia
        tv_alamat.text = alamat
        tv_pekerjaan.text = pekerjaan
    }

    private fun onlyName() {
        tv_namaDua.text = nama
    }

    private fun cekUsia(usia: Int): String {
        return if (usia % 2 == 0) {
            "$usia, bernilai Genap"
        } else {
            "$usia, bernilai Ganjil"
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}