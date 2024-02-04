package com.dev.sonu.theme.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.dev.sonu.theme.MiniTalesTheme
import com.dev.sonu.theme.R

@Composable
fun AppBar(
    title: String, navIcon: ImageVector? = null, onNav: () -> Unit = {}
) {
    TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        titleContentColor = MaterialTheme.colorScheme.primary
    ), title = { Text(text = title) }, navigationIcon = {
        navIcon?.let {
            IconButton(onClick = onNav) {
                Icon(
                    imageVector = it, contentDescription = stringResource(R.string.nav_icon)
                )
            }
        }
    })

}

@Composable
@MiniTalesPreview
private fun AppBarPreview() {
    MiniTalesTheme {
        Surface {
            AppBar(title = "Mini tales", navIcon = Icons.Filled.ArrowBack)

        }
    }
}