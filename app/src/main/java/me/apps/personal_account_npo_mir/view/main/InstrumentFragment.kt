package me.apps.personal_account_npo_mir.view.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import me.apps.personalaccountnpomir.R
import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random
import kotlin.random.nextInt

const val ARG_OBJECT = "object"

class InstrumentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_instrument, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
            val textView: TextView = view.findViewById(R.id.meterNameTextView2)
            val dateView: TextView = view.findViewById(R.id.dateTextView)
            val indicationsTextView = view.findViewById<TextView>(R.id.meterIndicationsTextView)
            textView.text = generateMeterName()
            indicationsTextView.text = generateIndications()
            dateView.text = currentDate.toString()
        }
    }

    private fun generateMeterName(): String {
        return (1..10).map { Random.nextInt(1..9) }.joinToString("")
    }

    private fun generateIndications(): String {
        return (1..3).map { Random.nextInt(1..9) }
            .joinToString("") + "." + (1..2).map { Random.nextInt(1..9) }.joinToString("")
    }


    private val simpleDate = SimpleDateFormat("dd.MM.yyyy hh:mm", Locale.GERMANY)
    private val currentDate = simpleDate.format(Date())

}