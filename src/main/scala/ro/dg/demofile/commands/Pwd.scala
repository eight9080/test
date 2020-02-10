package ro.dg.demofile.commands
import ro.dg.demofile.filesystem.State

class Pwd extends Command {

  override def apply(state: State): State =
    state.setMessage(state.wd.path)
}
