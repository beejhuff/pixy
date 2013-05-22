package at.ac.tuwien.infosys.www.pixy.analysis.literal.transferfunction;

import at.ac.tuwien.infosys.www.pixy.analysis.LatticeElement;
import at.ac.tuwien.infosys.www.pixy.analysis.TransferFunction;
import at.ac.tuwien.infosys.www.pixy.analysis.literal.LiteralLatticeElement;
import at.ac.tuwien.infosys.www.pixy.conversion.TacPlace;
import at.ac.tuwien.infosys.www.pixy.conversion.Variable;

import java.util.Set;

/**
 * Transfer function for unary assignment nodes.
 *
 * @author Nenad Jovanovic <enji@seclab.tuwien.ac.at>
 */
public class AssignUnary extends TransferFunction {
    private Variable left;
    private TacPlace right;
    private int op;
    private Set<Variable> mustAliases;
    private Set<Variable> mayAliases;

// *********************************************************************************
// CONSTRUCTORS ********************************************************************
// *********************************************************************************

    // mustAliases, mayAliases: of setMe
    public AssignUnary(
        TacPlace left, TacPlace right, int op, Set<Variable> mustAliases, Set<Variable> mayAliases
    ) {
        this.left = (Variable) left;  // must be a variable
        this.right = right;
        this.op = op;
        this.mustAliases = mustAliases;
        this.mayAliases = mayAliases;
    }

// *********************************************************************************
// OTHER ***************************************************************************
// *********************************************************************************

    public LatticeElement transfer(LatticeElement inX) {

        LiteralLatticeElement in = (LiteralLatticeElement) inX;
        LiteralLatticeElement out = new LiteralLatticeElement(in);

        // let the lattice element handle the details
        out.assignUnary(left, right, op, mustAliases, mayAliases);

        return out;
    }
}