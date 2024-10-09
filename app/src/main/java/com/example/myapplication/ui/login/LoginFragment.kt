package com.example.myapplication.ui.login

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.Spanned
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentLoginBinding

import com.example.myapplication.R
import com.google.android.material.textfield.TextInputEditText

class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel
    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        binding.iForgot.setOnClickListener{(findNavController().navigate(R.id.action_loginFragment_to_change_pass))}
        binding.login.setOnClickListener{(findNavController().navigate(R.id.action_loginFragment_to_blankFragment))}
        binding.sign.setOnClickListener{(findNavController().navigate(R.id.action_loginFragment_to_sign_up2))}
        val textInputEditText=view.findViewById<TextInputEditText>(R.id.username)
        textInputEditText.filters= arrayOf(EnglishInputFilter())
    }
}

class EnglishInputFilter : InputFilter {
    override fun filter(
        source: CharSequence?,
        start: Int,
        end: Int,
        dest: Spanned?,
        dstart: Int,
        dend: Int
    ): CharSequence? {
        TODO("Not yet implemented")
        if (source==null) return null
        for (i in start until end) {
            if (!source[i].isLetterOrDigit() && !source[i].isWhitespace()) {
                return ""
            }
        }
        return null
        }
    }

class AllSimbolsPass : InputFilter {
    override fun filter(
        source: CharSequence?,
        start: Int,
        end: Int,
        dest: Spanned?,
        dstart: Int,
        dend: Int
    ): CharSequence? {
        TODO("Not yet implemented")
        if(source==null)return null
        for (i in start until end) {
            if (!source[i].isLetterOrDigit() && !isSpecialCharacter(source[i])) {
                return ""
            }
        }
            return null
            }
    private fun isSpecialCharacter(char: Char):Boolean{
        val isSpecialChars = "!@#$%^&*()_+[]{}|;:',.<>?/"
        return char in isSpecialChars
    }

}


