package ikhwan.binar.challengechaptertiga

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_screen_empat.*


class FragmentScreenEmpat : Fragment(), View.OnClickListener {

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
        val person = arguments?.getParcelable<DataUser>(FragmentScreenTiga.EXTRA_PERSON) as DataUser
        nama = person.nama.toString()
        usia = person.usia.toString()
        alamat = person.alamat.toString()
        pekerjaan = person.pekerjaan.toString()

        if (usia != "null") {

            input_usia.setText(usia)
            input_alamat.setText(alamat)
            input_pekerjaan.setText(pekerjaan)

        }

        btn_tiga.setOnClickListener(this)
    }


    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_tiga -> {
                usia = input_usia.text.toString()
                alamat = input_alamat.text.toString()
                pekerjaan = input_pekerjaan.text.toString()

                val person = DataUser(nama, usia, alamat, pekerjaan)
                val mBundle = bundleOf(FragmentScreenTiga.EXTRA_PERSON to person)
                p0.findNavController()
                    .navigate(R.id.action_fragmentScreenEmpat_to_fragmentScreenTiga, mBundle)
            }
        }
    }

}