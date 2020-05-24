      package com.example.aboutme

      import android.content.Context
      import androidx.appcompat.app.AppCompatActivity
      import android.os.Bundle
      import android.provider.ContactsContract
      import android.view.View
      import android.view.inputmethod.InputMethodManager
      import android.widget.Button
      import android.widget.EditText
      import android.widget.TextView
      import androidx.core.content.ContextCompat.getSystemService
      import androidx.databinding.DataBindingUtil
      import com.example.aboutme.databinding.ActivityMainBinding

      class MainActivity : AppCompatActivity() {

          private lateinit var binding: ActivityMainBinding
          private val myName: MyName = MyName("Akash Verma")

          override fun onCreate(savedInstanceState: Bundle?){

              super.onCreate(savedInstanceState)
              binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
              binding.myName = myName

              binding.doneButton.setOnClickListener{
                  addNickname(it)
              }


          }

          private fun addNickname(view:View){
              binding.apply {
                  myName?.nickname = nicknameEdit.text.toString()
                  // Invalidate all binding expressions and request a new rebind to refresh UI
                  invalidateAll()
                  binding.nicknameEdit.visibility = View.GONE
                  binding.doneButton.visibility = View.GONE
                  binding.nicknameText.visibility = View.VISIBLE
              }

              //hide the keyboard
              val inn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
              inn.hideSoftInputFromWindow(view.windowToken, 0)

          }
      }
