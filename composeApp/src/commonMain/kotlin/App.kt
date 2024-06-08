import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import database.Contact
import database.ContactAppDatabase
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(dao: ContactAppDatabase) {
    MaterialTheme {
        val contact by dao.getDao().getAllContact().collectAsState(initial = emptyList())

        LaunchedEffect(key1 = true) {
            dao.getDao()
                .upsert(Contact(name = "Shreyansh", number = "12343", email = "ks@gmail.com"))
        }

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(contact) {
                Text(text = it.name)
            }
        }
    }
}