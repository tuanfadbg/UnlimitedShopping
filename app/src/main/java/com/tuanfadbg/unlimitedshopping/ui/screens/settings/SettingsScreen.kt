package com.tuanfadbg.unlimitedshopping.ui.screens.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tuanfadbg.unlimitedshopping.utils.LoggingPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    onBackClick: () -> Unit,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val isLoggingEnabled by viewModel.isLoggingEnabled.observeAsState(false)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("API Logging")
                Switch(
                    checked = isLoggingEnabled,
                    onCheckedChange = { viewModel.setLoggingEnabled(it) }
                )
            }
        }
    }
}

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val loggingPreferences: LoggingPreferences
) : androidx.lifecycle.ViewModel() {

    val isLoggingEnabled = androidx.lifecycle.MutableLiveData<Boolean>().apply {
        value = loggingPreferences.isLoggingEnabled
    }

    fun setLoggingEnabled(enabled: Boolean) {
        loggingPreferences.isLoggingEnabled = enabled
        isLoggingEnabled.value = enabled
    }
} 