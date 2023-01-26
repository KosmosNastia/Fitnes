package com.example.fitnes

import adapters.DayModel
import adapters.DaysAdapter
import adapters.ExerciseModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnes.databinding.FragmentDaysBinding
import utils.FragmentManager

class DaysFragment : Fragment(),DaysAdapter.Listener {
    private lateinit var binding: FragmentDaysBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDaysBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()
    }

    private fun initRcView() = with(binding){
        val adapter = DaysAdapter(this@DaysFragment)
        rcViewDays.layoutManager = LinearLayoutManager(activity as AppCompatActivity)
        rcViewDays.adapter = adapter
        adapter.submitList(fillDaysArray())
    }

    private fun fillDaysArray(): ArrayList<DayModel>{
        val tArray = ArrayList<DayModel>()
        resources.getStringArray(R.array.day_exercises).forEach {
            tArray.add(DayModel(it,false))
        }
        return tArray
    }

    private fun fillExerciseList(day: DayModel){
        val templist = ArrayList<ExerciseModel>()
        day.exercises.split(",").forEach {
            val exercisesList = resources.getStringArray(R.array.exercise)
            val exersise = exercisesList[it.toInt()]
            val exersiseArray = exersise.split("|")
            templist.add(ExerciseModel(exersiseArray[0],exersiseArray[1],exersiseArray[2]))
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = DaysFragment()
    }

    override fun onClick(day: DayModel) {
        fillExerciseList(day)
        FragmentManager.setFragments(ExercisesListFragment.newInstance(),
            activity as AppCompatActivity)
    }

}