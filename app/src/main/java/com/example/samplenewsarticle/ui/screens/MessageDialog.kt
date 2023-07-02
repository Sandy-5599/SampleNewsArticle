import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.samplenewsarticle.R

@Composable
fun MessageDialog(
    title: String,
    showDialog: MutableState<Boolean>,
    message: String,
    onClose: () -> Unit
) {
    if (showDialog.value) {
        Column(
            modifier = Modifier
                .testTag(stringResource(id = R.string.error_screen))
                .padding(16.dp)
        ) {
            AlertDialog(
                onDismissRequest = onClose,
                title = { Text(text = title) },
                text = { Text(text = message) },
                confirmButton = {
                    Button(
                        onClick = onClose,
                        modifier = Modifier.padding(top = 8.dp)
                    ) {
                        Text(text = stringResource(id = R.string.ok_button_text))
                    }
                }
            )
        }
    }
}