package ikhwan.binar.challengechaptertiga

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_screen_empat.*


@Suppress("NAME_SHADOWING")
class FragmentScreenEmpat : Fragment(){

    private lateinit var nama: String
    private lateinit var usia: String
    private lateinit var alamat: String
    private lateinit var pekerjaan: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_screen_empat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataUser = arguments?.getParcelable<DataUser>(FragmentScreenTiga.EXTRA_DATA) as DataUser

        nama = dataUser.nama.toString()
        usia = dataUser.usia.toString()
        alamat = dataUser.alamat.toString()
        pekerjaan = dataUser.pekerjaan.toString()

        cekData()
        openTiga()
    }

    private fun openTiga() {
        btn_tiga.setOnClickListener{
            usia = input_usia.text.toString()
            alamat = input_alamat.text.toString()
            pekerjaan = input_pekerjaan.text.toString()

            val dataUser = DataUser(nama, usia, alamat, pekerjaan)
            val mBundle = bundleOf(FragmentScreenTiga.EXTRA_DATA to dataUser)
            it.findNavController()
                .navigate(R.id.action_fragmentScreenEmpat_to_fragmentScreenTiga, mBundle)
        }
    }

    private fun cekData() {
        if (usia != "null") {
            input_usia.setText(usia)
            input_alamat.setText(alamat)
            input_pekerjaan.setText(pekerjaan)
        }
    }


}