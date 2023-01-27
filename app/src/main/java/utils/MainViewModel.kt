package utils

import adapters.ExerciseModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
     val mutableListExersie = MutableLiveData<ArrayList<ExerciseModel>>()
}