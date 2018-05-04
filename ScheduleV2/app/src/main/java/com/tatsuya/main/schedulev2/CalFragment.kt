package com.tatsuya.main.schedulev2

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import kotlinx.android.synthetic.main.fragment_cal.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CalFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [CalFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class CalFragment : Fragment(), CalendarView.OnDateChangeListener {

    lateinit var parent: MainActivity

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        parent = context as MainActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cal: Calendar = Calendar.getInstance()
        calendarView.setOnDateChangeListener(this)
        textView2.text = cal.get(Calendar.YEAR).toString() + "/" + (cal.get(Calendar.MONTH)+1).toString() + "/" + cal.get(Calendar.DAY_OF_MONTH).toString()
        addbutton.setOnClickListener { parent.addmove(textView2.text.toString()) }
        listbutton.setOnClickListener { parent.listmove() }
        TimeButton.setOnClickListener { parent.timemove() }

    }

    override fun onSelectedDayChange(view: CalendarView?, year: Int, month: Int, dayOfMonth: Int) {
        textView2.text = year.toString() + "/" + (month+1).toString() + "/" + dayOfMonth.toString()
    }

}
