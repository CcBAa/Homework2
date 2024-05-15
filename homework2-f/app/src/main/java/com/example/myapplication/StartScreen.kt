import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StartScreen(spots: List<String>, navigateToDetail: (Int) -> Unit) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        itemsIndexed(spots) { index, name ->
            SpotItem(name, index, navigateToDetail)
        }
    }
}

@Composable
fun SpotItem(name: String, index: Int, navigateToDetail: (Int) -> Unit) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = name, fontSize = 20.sp)
            }
            ElevatedButton(onClick = { navigateToDetail(index) }) {
                Text("more detail", fontSize = 16.sp)
            }
        }
    }
}