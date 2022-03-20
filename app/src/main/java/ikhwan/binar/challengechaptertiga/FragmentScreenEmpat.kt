package ikhwan.binar.challengechaptertiga

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import ikhwan.binar.challengechaptertiga.databinding.FragmentScreenEmpatBinding

class FragmentScreenEmpat : Fragment() , View.OnClickListener {

    private var _binding : FragmentScreenEmpatBinding? = null
    private val binding get() = _binding!!
    private lateinit var nama: String
    private lateinit var usia: String
    private lateinit var alamat: String
    private lateinit var pekerjaan: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScreenEmpatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nama = arguments?.getString(FragmentScreenTiga.EXTRA_NAMA).toString()
        usia = arguments?.getString(FragmentScreenTiga.EXTRA_USIA).toString()
        alamat = arguments?.getString(FragmentScreenTiga.EXTRA_ALAMAT).toString()
        pekerjaan = arguments?.getString(FragmentScreenTiga.EXTRA_PEKERJAAN).toString()

        if (usia !="null"){
            binding.apply {
                inputUsia.setText(usia)
                inputAlamat.setText(alamat)
                inputPekerjaan.setText(pekerjaan)
            }
        }

        binding.btnTiga.setOnClickListener(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn_tiga -> {
                binding.apply {
                    usia = inputUsia.text.toString()
                    alamat = inputAlamat.text.toString()
                    pekerjaan = inputPekerjaan.text.toString()
                }
                val mBundle = Bundle()
                mBundle.putString(FragmentScreenTiga.EXTRA_NAMA, nama)
                mBundle.putString(FragmentScreenTiga.EXTRA_USIA, usia)
                mBundle.putString(FragmentScreenTiga.EXTRA_ALAMAT, alamat)
                mBundle.putString(FragmentScreenTiga.EXTRA_PEKERJAAN, pekerjaan)
                p0.findNavController().navigate(R.id.action_fragmentScreenEmpat_to_fragmentScreenTiga, mBundle)
            }
        }
    }

}