package ikhwan.binar.challengechaptertiga

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import ikhwan.binar.challengechaptertiga.databinding.FragmentScreenTigaBinding

class FragmentScreenTiga : Fragment(), View.OnClickListener {

    private var _binding: FragmentScreenTigaBinding? = null
    private val binding get() = _binding!!
    private lateinit var nama: String
    private lateinit var usia: String
    private lateinit var alamat: String
    private lateinit var pekerjaan: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScreenTigaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nama = arguments?.getString(EXTRA_NAMA).toString()
        usia = arguments?.getString(EXTRA_USIA).toString()
        alamat = arguments?.getString(EXTRA_ALAMAT).toString()
        pekerjaan = arguments?.getString(EXTRA_PEKERJAAN).toString()

        if (usia == "null") {
            onlyName()
        } else {
            fullData()
        }

        binding.btnEmpat.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_empat -> {
                val mBundle = Bundle()
                mBundle.putString(EXTRA_NAMA, nama)
                mBundle.putString(EXTRA_USIA, usia)
                mBundle.putString(EXTRA_ALAMAT, alamat)
                mBundle.putString(EXTRA_PEKERJAAN, pekerjaan)

                p0.findNavController()
                    .navigate(R.id.action_fragmentScreenTiga_to_fragmentScreenEmpat, mBundle)
            }
        }
    }

    private fun fullData() {
        binding.apply {
            val textUsia = if (usia != "") {
                cekUsia(usia.toInt())
            } else {
                ""
            }

            tvNamaDua.text = ""
            tvNama.text = nama
            tvUsia.text = textUsia
            tvAlamat.text = alamat
            tvPekerjaan.text = pekerjaan
        }
    }

    private fun onlyName() {
        binding.tvNamaDua.text = nama
    }

    private fun cekUsia(usia: Int): String {
        return if (usia % 2 == 0) {
            "$usia, bernilai Genap"
        } else {
            "$usia, bernilai Ganjil"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val EXTRA_NAMA = "extra_nama"
        const val EXTRA_USIA = "extra_usia"
        const val EXTRA_ALAMAT = "extra_alamat"
        const val EXTRA_PEKERJAAN = "extra_pekerjaan"
    }
}