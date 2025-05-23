@file:OptIn(ExperimentalMaterial3Api::class)

package dev.abhinav.run.presentation.run_overview

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.abhinav.core.presentation.designsystem.AnalyticsIcon
import dev.abhinav.core.presentation.designsystem.LogoIcon
import dev.abhinav.core.presentation.designsystem.LogoutIcon
import dev.abhinav.core.presentation.designsystem.RunIcon
import dev.abhinav.core.presentation.designsystem.RuntrackerTheme
import dev.abhinav.core.presentation.designsystem.components.RuntrackerFloatingActionButton
import dev.abhinav.core.presentation.designsystem.components.RuntrackerScaffold
import dev.abhinav.core.presentation.designsystem.components.RuntrackerToolbar
import dev.abhinav.core.presentation.designsystem.components.util.DropDownItem
import dev.abhinav.run.presentation.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun RunOverviewScreenRoot(
    onStartRunClick: () -> Unit,
    viewModel: RunOverviewViewModel = koinViewModel(),
) {
    RunOverviewScreen(
        onAction = { action ->
            when(action) {
                RunOverviewAction.OnStartClick -> onStartRunClick()
                else -> Unit
            }
            viewModel.onAction(action)
        }
    )
}

@Composable
private fun RunOverviewScreen(
    onAction: (RunOverviewAction) -> Unit
) {
    val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = topAppBarState
    )
    RuntrackerScaffold(
        topAppBar = {
            RuntrackerToolbar(
                showBackButton = false,
                title = stringResource(id = R.string.runtracker),
                scrollBehavior = scrollBehavior,
                menuItems = listOf(
                    DropDownItem(
                        icon = AnalyticsIcon,
                        title = stringResource(id = R.string.analytics)
                    ),
                    DropDownItem(
                        icon = LogoutIcon,
                        title = stringResource(id = R.string.logout)
                    ),
                ),
                onMenuItemClick = { index ->
                    when (index) {
                        0 -> onAction(RunOverviewAction.OnAnalyticsClick)
                        1 -> onAction(RunOverviewAction.OnLogoutClick)
                    }
                },
                startContent = {
                    Icon(
                        imageVector = LogoIcon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(30.dp)
                    )
                }
            )
        },
        floatingActionButton = {
            RuntrackerFloatingActionButton(
                icon = RunIcon,
                onClick = {
                    onAction(RunOverviewAction.OnStartClick)
                }
            )
        }
    ) { padding ->

    }
}

@Preview
@Composable
private fun RunOverviewScreenPreview() {
    RuntrackerTheme {
        RunOverviewScreen(
            onAction = {}
        )
    }
}