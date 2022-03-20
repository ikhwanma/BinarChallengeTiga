package ikhwan.binar.challengechaptertiga

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import ikhwan.binar.challengechaptertiga.databinding.FragmentScreenDuaBinding

class FragmentScreenDua : Fragment() , View.OnClickListener{

    private var _binding : FragmentScreenDuaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScreenDuaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnTiga.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn_tiga -> {
                val nama = binding.inputNama.text.toString()
                val mBundle = Bundle()
                mBundle.putString(FragmentScreenTiga.EXTRA_NAMA, nama)
                p0.findNavController().navigate(R.id.action_fragmentScreenDua_to_fragmentScreenTiga, mBundle)
            }
        }
    }

}