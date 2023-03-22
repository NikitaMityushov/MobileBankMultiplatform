package com.mityushovn.mobilebankmultiplatform.android.feature_auth.api

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.mityushovn.mobilebankmultiplatform.android.feature_auth.R
import com.mityushovn.mobilebankmultiplatform.android.feature_auth.internal.presentation.phoneNumberScreen.PhoneNumberScreen
import com.mityushovn.mobilebankmultiplatform.android.ui.theme.BankTheme
import com.mityushovn.mobilebankmultiplatform.shared.auth.api.AuthVmFactories
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.presentation.PhoneNumberViewModel
import kotlinx.coroutines.launch

class AuthFragment : Fragment() {
    private val viewModel by viewModels<PhoneNumberViewModel> {
        AuthVmFactories.phoneNumberVMFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                BankTheme {
                    PhoneNumberScreen(viewModel = viewModel)
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewLifecycleOwner) {
            lifecycleScope.launch {
                lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.uiState.collect {
                        if (it.navigateToPasswordScreen) {
                            findNavController().navigate(R.id.action_authFragment_to_passwordFragment)
                        }
                    }
                }
            }
        }
    }
}