package me.apps.personalaccountnpomir.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import me.apps.personalaccountnpomir.R
import me.apps.personalaccountnpomir.interfaces.OnFragmentLogDataListener

class LogInFragment : Fragment() {

    private var regButton : Button? = null

    private var mListener : OnFragmentLogDataListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view : View? = inflater.inflate(R.layout.fragment_log_in, container, false)

        regButton = view?.findViewById(R.id.regButt)

        regButton?.setOnClickListener(){
            fun onClick(view: View){
                mListener?.onOpenFragment2()
            }
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_log_in, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) : LogInFragment {
            return LogInFragment()
        }
    }
}