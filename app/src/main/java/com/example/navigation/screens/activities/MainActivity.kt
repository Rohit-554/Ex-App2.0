package com.example.navigation.screens.activities

//Rohit -- 16-11-22 -- 13:36 (started project added dependencies and initiated project)
// Update -- 25-11-22 -- 16:56 (Splash screen api added)
//Update 3 -- 28-11-22 -- 10:02 AM (Login and Sign Up done with Firebase)
//update 4 -- 29-11-22 -- 16:41 navigation (some issues left like after  exiting the app when backbutton pressed)
//update 5 -- 04-12-22 -- 11:47 navigation resolved!
//update 6 -- 07-12-22 -- 12:44 Giphy Api Integrated ! Ui display left
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.navigation.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var googleSignInClient:GoogleSignInClient
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAuth = FirebaseAuth.getInstance()
    }

    override fun onStart() {
        super.onStart()
        if(mAuth.currentUser!=null){
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            val navController = navHostFragment.navController
            navController.navigate(R.id.apphome)
        }

    }


}