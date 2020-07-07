import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimulationTest {
    Robot robot;
    Simulation simulation;
    @Before
    public void setup(){
        simulation = new Simulation();
    }

    @Test
    public void testSimulateWhenInput73WTravereRAALALOutput94W(){
        robot= new Robot(7,3,'N');
        String traverse = "RAALAL";
        String result = simulation.simulate(robot,traverse.toCharArray());
        Assert.assertEquals("9 4 W",result);
    }


}
