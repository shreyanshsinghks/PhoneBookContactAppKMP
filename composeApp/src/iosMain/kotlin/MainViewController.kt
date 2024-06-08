import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController {
    val dao = getDatabaseBuilder()
    App(dao)
}