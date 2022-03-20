package ikhwan.binar.challengechaptertiga

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import ikhwan.binar.challengechaptertiga.databinding.FragmentScreenSatuBinding

class FragmentScreenSatu : Fragment(), View.OnClickListener {

    private var _binding : FragmentScreenSatuBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScreenSatuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnDua.setOnClickListener(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn_dua ->{
                p0.findNavController().navigate(R.id.action_fragmentScreenSatu_to_fragmentScreenDua)
            }
        }
    }

}