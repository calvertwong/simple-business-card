package com.calvertanddev.aa.login.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.calvertanddev.aa.login.LoginBaseFragment
import com.calvertanddev.aa.login.LoginConstants
import com.calvertanddev.aa.login.R
import com.calvertanddev.aa.login.databinding.FragmentLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.Status
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : LoginBaseFragment<FragmentLoginBinding>() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setBinding(FragmentLoginBinding.inflate(inflater, container, false))
        val gso: GoogleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .build()
        googleSignInClient = GoogleSignIn.getClient(requireContext(), gso)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.googleSignInButton.setOnClickListener {
            signInWithGoogle()
        }
    }

    override fun onStart() {
        super.onStart()

        // check if a user is already signed in
        val lastSignedInGoogleAccount: GoogleSignInAccount? = GoogleSignIn.getLastSignedInAccount(requireContext())
        updateUI(lastSignedInGoogleAccount)
    }

    // start an intent asking for a google account to sign in with
    private fun signInWithGoogle() {
        val googleSignInIntent: Intent = googleSignInClient.signInIntent
        startActivityForResult(googleSignInIntent, LoginConstants.RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == LoginConstants.RC_SIGN_IN) {
            val googleSignInTask: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(googleSignInTask)
        }
    }

    private fun handleSignInResult(task: Task<GoogleSignInAccount>) {
        try {
            val newSignedInGoogleAccount: GoogleSignInAccount? = task.getResult(ApiException::class.java)
            updateUI(newSignedInGoogleAccount)
        } catch (e: ApiException) {
            errorHandler.displayErrorDialog(
                title = "Unable to sign in with your Google account",
                message = "Please try again with the same/different account or report this issue.",
                positiveButtonText = "Try again",
                negativeButtonText = "Report issue"
            ).show(parentFragmentManager, "")

            // TODO: action to report issue
        }
    }

    private fun updateUI(signedInGoogleAccount: GoogleSignInAccount?) {
        signedInGoogleAccount?.let {
            navigateTo(R.id.action_goto_home, null)
        }
    }
}