package what

import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import org.slf4j._
import scala.jdk.CollectionConverters._
import scala.collection.SortedSet

object App {

  val log = LoggerFactory.getLogger(classOf[App])

  val format = "yyyy-MM-dd HH:mm:ss"

  def allZoneIds: Set[String] = ZoneId.getAvailableZoneIds().asScala.toSet

  def main(args: Array[String]): Unit = {

    val sourceTimestamp = "2021-10-30 23:06:13"
    val sourceZone = "Asia/Taipei"
    val targetZone = "Asia/Tokyo"

    val formatter = DateTimeFormatter.ofPattern(format)
    val formattedSourceTimestamp = LocalDateTime.parse(sourceTimestamp, formatter)
    val sourceZoneId = ZoneId.of(sourceZone); 

    val sourceDateTime = formattedSourceTimestamp.atZone(sourceZoneId);
    log.info(s"Source time zone ${sourceZone}'s time: $sourceDateTime")

    val targetZoneId = ZoneId.of(targetZone);
    val targetDateTime = sourceDateTime.withZoneSameInstant(targetZoneId);

    log.info(s"Target time zone ${targetZone}'s time: $targetDateTime")

  }

}
