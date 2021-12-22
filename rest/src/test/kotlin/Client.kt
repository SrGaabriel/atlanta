import com.atlanta.project.RestClient
import com.atlanta.project.request.message.CreateMessageRequest
import com.atlanta.project.request.message.EditMessageRequest
import com.atlanta.project.utils.AtlantaExperimental

@OptIn(AtlantaExperimental::class)
suspend fun main() {
    val restClient = RestClient("NzYyMzI4MTQyMzc5MzUyMTA1.X3njaA.jYaCKuctyxGhCSQh1Q5foJcGLYM")
    /*val restMessage = restClient.messageService.createMessage(923257436779999302, CreateMessageRequest(
        content = "Hello, World!"
    ))*/
    restClient.messageService.editMessage(923257436779999302, 923306342763069492, EditMessageRequest(
        "Hello, Moon!"
    ))
}