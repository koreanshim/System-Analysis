package midterm;
import java.awt.Dimension;
import java.awt.Point;

import simView.ViewableAtomic;
import simView.ViewableComponent;
import simView.ViewableDigraph;

public class ef extends ViewableDigraph
{
	
	public ef()
	{
		this("ef", 10, 10);
	}
	
	public ef(String name, double int_arr_t, double observe_t)
	{
		super(name);
		
		addInport("prob_in"); 
		addOutport("prob_out");
		
		ViewableAtomic prime = new proc_prime("prime", int_arr_t);
		ViewableAtomic power = new proc_power("power", observe_t);

		add(prime);
		add(power);

		addCoupling(this, "prob_in", prime, "ariv");
		addCoupling(prime, "solved", power, "ariv");
		addCoupling(power, "final", this, "prob_out");
	}

    
    /**
     * Automatically generated by the SimView program.
     * Do not edit this manually, as such changes will get overwritten.
     */
    public void layoutForSimView()
    {
        preferredSize = new Dimension(538, 448);
        ((ViewableComponent)withName("prime")).setPreferredLocation(new Point(83, 107));
        ((ViewableComponent)withName("power")).setPreferredLocation(new Point(104, 242));
    }
}