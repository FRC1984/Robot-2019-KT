package frc.team1984.lib.motion

import frc.team1984.robot.consts.Consts
import com.google.gson.Gson
import jaci.pathfinder.Pathfinder
import jaci.pathfinder.Trajectory
import jaci.pathfinder.Waypoint
import jaci.pathfinder.modifiers.TankModifier
import java.io.File
import java.security.InvalidParameterException

/**
 * Class to handle Pathfinder trajectories and serialization.
 * @param wheelbaseWidth Width of robot wheelbase
 * @param pathName Name of path, e.g. "CS_L"
 * @param baseFilePath Where to store all the path data
 * @constructor Constructs a shell of a Pathfinder path/trajectory
 */
class PFPath(
        val pathName: String,
        private val baseFilePath: String = Consts.PF_PATH
) {

    /**
     * Secondary constructor if not deserializing.
     */
    constructor(
            pathData: Metadata,
            pathName: String,
            baseFilePath: String = Consts.PF_PATH
    ) : this(pathName, baseFilePath) {
        this.pathData = pathData
    }

    // You MUST either generate the trajectory or deserialize it from something!
    var trajectory: Trajectory? = null
    var modifier: TankModifier? = null
    var pathData: Metadata? = null

    // Pathfinder trajectory CSV
    private val csvFile = File("$baseFilePath/$pathName/trajectory.csv")
    // Associated Pathfinder metadata JSON
    private val jsonFile = File("$baseFilePath/$pathName/metadata.json")

    /**
     * Generate trajectory and modifier.
     */
    fun generate() {
        if (pathData == null) {
            throw InvalidParameterException("No metadata given! Wrong constructor?")
        } else {
            trajectory = Pathfinder.generate(pathData!!.waypoints, pathData!!.trajectoryConf)
            modifier = TankModifier(trajectory).modify(pathData!!.wheelbaseWidth)
        }
    }

    /**
     * Deserialize trajectory and other data from CSV and JSON.
     */
    fun deserialize() {
        // JSON
        val gson = Gson()
        val bufferedReader = jsonFile.bufferedReader()
        val jsonText = bufferedReader.use { it.readText() }
        pathData = gson.fromJson(jsonText, Metadata::class.java)

        // CSV
        println("CSV File: $csvFile")
        trajectory = Pathfinder.readFromCSV(csvFile)
        modifier = TankModifier(trajectory).modify(pathData!!.wheelbaseWidth)
    }

    /**
     * Serialize trajectory, config, and waypoints.
     * NOT null safe. Only call after generate or deserialize.
     * @param csvName Filename to save trajectory to
     */
    fun serialize() {
        // CSV
        Pathfinder.writeToCSV(csvFile, trajectory)

        // JSON
        val gson = Gson()
        val jsonStr = gson.toJson(pathData)
        jsonFile.writeText(jsonStr)
    }

    data class Metadata(
            val waypoints: Array<Waypoint>,
            val trajectoryConf: Trajectory.Config,
            val wheelbaseWidth: Double
    )
}