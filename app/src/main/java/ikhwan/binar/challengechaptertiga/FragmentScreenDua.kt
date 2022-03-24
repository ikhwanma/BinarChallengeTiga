package ikhwan.binar.challengechaptertiga

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_screen_dua.*

class FragmentScreenDua : Fragment() , View.OnClickListener{

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_screen_dua,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_tiga.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn_tiga -> {
                val nama = input_nama.text.toString()
                val person = DataUser(nama,null,null,null)
                val mBundle = bundleOf(FragmentScreenTiga.EXTRA_PERSON to person)
                p0.findNavController().navigate(R.id.action_fragmentScreenDua_to_fragmentScreenTiga, mBundle)
            }
        }
    }

}