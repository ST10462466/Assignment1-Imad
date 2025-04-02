package vcmsa.ci.meal_suggestionapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Declaring our UI/variables in this first section of our coding
        val inputbox = findViewById<EditText>(R.id.inputbox)
        val suggestbutton = findViewById<Button>(R.id.suggestbutton)
        val clearbutton = findViewById<Button>(R.id.clearbutton)
        val mealview = findViewById<TextView>(R.id.mealview)
        // Author : Zahra Bulbulia
        // url : https://www.youtube.com/watch?v=R5p-YXC87VU

        //Here the suggestbutton is linked to the code and also using "when and else" statement to suggest to the user the different meals
        suggestbutton.setOnClickListener {
            val timeofday = inputbox.text.toString().trim()
            val suggestedmeal = when (timeofday.lowercase()){
                "morning" -> "Good morning! Get ready for the day. How about some scrambled eggs with toast ? "
                "mid-morning" -> "Feeling a little hungry? Oatmeal with fruits and nuts sounds like a great idea! Wanna try?"
                "afternoon" -> "It's lunchtime! Time for a heavy meal... What do you think about Mac and Cheese ?"
                "mid-afternoon" -> "Stay focused dear. A Shrimp stir-fry should keep you going."
                "dinner" -> "End your day on a tasty note... how about some homemade Pizza ?"
                    else -> "Please enter a correct time ! "
            }
            // Author : Zahra Bulbulia
            // url : https://www.youtube.com/watch?v=R5p-YXC87VU

            // Linking the box mealview to the variable suggestedmeal
            mealview.text = suggestedmeal
        }

        // Linking the clearbutton to the inputbox and mealview to clear the text after displaying
        clearbutton.setOnClickListener{
            inputbox.text.clear()
            mealview.text = ""

        }
    }
}
// Author : Zahra Bulbulia
// url : https://www.youtube.com/watch?v=R5p-YXC87VU
