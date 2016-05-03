package ch.epfl.scala.index

case class ArtifactRef(
  groupId: String,
  artifactId: String,
  version: String
)

case class ISO_8601_Date(value: String)

case class Artifact(
  name: Option[String],
  description: Option[String],
  ref: ArtifactRef,
  releaseDates: List[ISO_8601_Date],
  mavenCentral: Boolean,
  dependencies: Set[ArtifactRef],
  github: Set[GithubRepo],
  licenses: Set[License]
) {
  def scalaDocURI: Option[String] = {
    if(mavenCentral) {
      import ref._
      Some(s"https://www.javadoc.io/doc/$groupId/$artifactId/$version")
    } else None
  }
}

case class GithubRepo(user: String, repo: String)
