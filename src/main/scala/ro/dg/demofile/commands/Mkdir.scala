package ro.dg.demofile.commands
import ro.dg.demofile.files.{DirEntry, Directory}
import ro.dg.demofile.filesystem.State

class Mkdir(name: String) extends CreateEntry(name) {
  override def createSpecificEntry(state: State): DirEntry =
    Directory.empty(state.wd.path, name)
}
