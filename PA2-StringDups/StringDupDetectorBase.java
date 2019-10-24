/*
 *  Assignment: Comparing String Duplicate Algorithms
 *
 *  StringDupDetectorBase: Base class for different kinds of String
 *   Duplicates Detector / Filter
 *   Defines common features and API
 * 
 *  Contributors:
 *    Aaron S. Crandall <acrandal@wsu.edu>, 2019
 * 
 *  Copyright:
 *   For academic use only under the Creative Commons
 *   Attribution-NonCommercial-NoDerivatives 4.0 International License
 *   http://creativecommons.org/licenses/by-nc-nd/4.0
 */

 import java.util.ArrayList;

abstract class StringDupDetectorBase
{
    public String algorithm_name = "Base alg-should fail";
    public String description = "No description";
    public String complexity = "INF";


    public abstract ArrayList<String> doDupDetection(ArrayList<String> strings);
}
