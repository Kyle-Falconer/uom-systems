/*
 *  Unit Systems
 *  Copyright (c) 2005-2016, Jean-Marie Dautelle, Werner Keil, V2COM.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions
 *    and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-363 nor the names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package systems.uom.unicode;

import static tec.units.ri.unit.MetricPrefix.*;
import static tec.units.ri.unit.Units.CUBIC_METRE;
import static tec.units.ri.unit.Units.METRE;
import static tec.units.ri.unit.Units.SQUARE_METRE;
import static tec.units.ri.AbstractUnit.ONE;
import si.uom.quantity.Action;
import systems.uom.quantity.Information;
import systems.uom.quantity.InformationRate;
import si.uom.SI;
import tec.units.ri.*;
import tec.units.ri.format.SimpleUnitFormat;
import tec.units.ri.function.PiMultiplierConverter;
import tec.units.ri.function.RationalConverter;
import tec.units.ri.unit.AlternateUnit;
import tec.units.ri.unit.ProductUnit;
import tec.units.ri.unit.TransformedUnit;
import tec.units.ri.unit.Units;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.*;

/**
 * <p>
 * This class contains {@link SI} and Non-SI units as defined in the <a
 * href="http//cldr.unicode.org/">Unicode CLDR Project</a>.
 * </p>
 *
 * <p>
 * Compatibility with {@link SI} units has been given priority over strict
 * adherence to the standard. We have attempted to note every place where the
 * definitions in this class deviate from the CLDR standard, but such notes are
 * likely to be incomplete.
 * </p>
 * 
 * @noextend This class is not intended to be extended by clients.
 *
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @see <a href="http://cldr.unicode.org">Unicode CLDR</a>
 * @version 0.2, $Date: 2016-04-30 $
 */
public final class CLDR extends AbstractSystemOfUnits {

    /**
     * The singleton instance.
     */
    private static final CLDR INSTANCE = new CLDR();

    /**
     * Default constructor (prevents this class from being instantiated).
     */
    private CLDR() {
    }

    /**
     * Returns the singleton instance of this class.
     *
     * @return the CLDR system instance.
     */
    public static CLDR getInstance() {
	return INSTANCE;
    }

    // //////////
    // Length //
    // //////////
    /**
     * US name for {@link SI#METRE}.
     */
    public static final Unit<Length> METER = METRE;

    /**
     * A unit of length equal to <code>0.3048 m</code> (standard name
     * <code>ft</code>).
     */
    public static final Unit<Length> FOOT = addUnit(METER.multiply(3048)
	    .divide(10000));

    /**
     * A unit of length equal to <code>1200/3937 m</code> (standard name
     * <code>foot_survey_us</code>). See also: <a
     * href="http://www.sizes.com/units/foot.htm">foot</a>
     */
    public static final Unit<Length> FOOT_SURVEY = addUnit(METER.multiply(1200)
	    .divide(3937));

    /**
     * A unit of length equal to <code>0.9144 m</code> (standard name
     * <code>yd</code>).
     */
    public static final Unit<Length> YARD = addUnit(FOOT.multiply(3));

    /**
     * A unit of length equal to <code>0.0254 m</code> (standard name
     * <code>in</code>).
     */
    public static final Unit<Length> INCH = addUnit(FOOT.divide(12));

    /**
     * A unit of length equal to <code>1609.344 m</code> (standard name
     * <code>mi</code>).
     */
    public static final Unit<Length> MILE = addUnit(METER.multiply(1609344)
	    .divide(1000));

    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<Time> SECOND = addUnit(Units.SECOND);

    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<Angle> RADIAN = addUnit(Units.RADIAN);
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<Temperature> KELVIN = addUnit(Units.KELVIN);
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<ElectricCharge> COULOMB = addUnit(Units.COULOMB);
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<LuminousIntensity> CANDELA = addUnit(Units.CANDELA);

    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<Dimensionless> PI = addUnit(ONE
	    .transform(new PiMultiplierConverter()));
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<Dimensionless> PERCENT = addUnit(ONE.divide(100));

    // //////////////////////////
    // SI UNITS: CLDR          //
    // //////////////////////////
    /**
     * We deviate slightly from the standard here, to maintain compatibility
     * with the existing SI units. In CLDR, the mole is no longer a base unit,
     * but is defined as <code>Unit.ONE.multiply(6.0221367E23)</code>.
     */
    public static final Unit<AmountOfSubstance> MOLE = addUnit(Units.MOLE);
    /**
     * We deviate slightly from the standard here, to maintain compatibility
     * with the existing SI units. In CLDR, the steradian is defined as
     * <code>RADIAN.pow(2)</code>.
     */
    public static final Unit<SolidAngle> STERADIAN = addUnit(Units.STERADIAN);

    public static final Unit<Frequency> HERTZ = addUnit(Units.HERTZ);
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<Force> NEWTON = addUnit(Units.NEWTON);
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<Pressure> PASCAL = addUnit(Units.PASCAL);
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<Energy> JOULE = addUnit(Units.JOULE);
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<Power> WATT = addUnit(Units.WATT);
    /**
     * We deviate slightly from the standard here, to maintain compatability
     * with the existing SI units. In CLDR, the ampere is defined as
     * <code>COULOMB.divide(SECOND)</code>.
     */
    public static final Unit<ElectricCurrent> AMPERE = addUnit(Units.AMPERE);

    /**
     * We deviate slightly from the standard here, to maintain compatibility
     * with the existing SI units. In CLDR, the volt is defined as
     * <code>JOULE.divide(COULOMB)</code>.
     */
    public static final Unit<ElectricPotential> VOLT = addUnit(Units.VOLT);
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<ElectricCapacitance> FARAD = addUnit(Units.FARAD);
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<ElectricResistance> OHM = addUnit(Units.OHM);
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<ElectricConductance> SIEMENS = addUnit(Units.SIEMENS);
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<MagneticFlux> WEBER = addUnit(Units.WEBER);
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<Temperature> CELSIUS = addUnit(Units.CELSIUS);
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<MagneticFluxDensity> TESLA = addUnit(Units.TESLA);
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<ElectricInductance> HENRY = addUnit(Units.HENRY);
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<LuminousFlux> LUMEN = addUnit(Units.LUMEN);
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<Illuminance> LUX = addUnit(Units.LUX);
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<Radioactivity> BECQUEREL = addUnit(Units.BECQUEREL);
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<RadiationDoseAbsorbed> GRAY = addUnit(Units.GRAY);
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<RadiationDoseEffective> SIEVERT = addUnit(Units.SIEVERT);

    /**
     * Holds the Avogadro constant.
     */
    private static final double AVOGADRO_CONSTANT = 6.02214199e23; // (1/mol).

    /**
     * Holds the electric charge of one electron.
     */
    private static final double ELEMENTARY_CHARGE_CONSTANT = 1.602176462e-19; // (C).

    // ///////////////////
    // Electric charge //
    // ///////////////////
    /**
     * A unit of electric charge equal to the charge on one electron (standard
     * name <code>e</code>).
     */
    static final Unit<ElectricCharge> E = addUnit(COULOMB
	    .multiply(ELEMENTARY_CHARGE_CONSTANT));

    /**
     * A unit of electric charge equal to equal to the product of Avogadro's
     * number (see {@link SI#MOLE}) and the charge (1 e) on a single electron
     * (standard name <code>Fd</code>).
     */
    static final Unit<ElectricCharge> FARADAY = addUnit(COULOMB
	    .multiply(ELEMENTARY_CHARGE_CONSTANT * AVOGADRO_CONSTANT)); // e/mol

    /**
     * A unit of electric charge which exerts a force of one dyne on an equal
     * charge at a distance of one centimeter (standard name <code>Fr</code>).
     */
    static final Unit<ElectricCharge> FRANKLIN = addUnit(COULOMB
	    .multiply(3.3356e-10));

    /**
     * We deviate slightly from the standard here, to maintain compatibility
     * with the existing NonSI units. In CLDR, the degree is defined as
     * <code>PI.multiply(RADIAN.divide(180))</code>.
     */
    public static final Unit<Angle> DEGREE = addUnit(SI.DEGREE_ANGLE);

    /**
     * As per CLDR standard.
     */
    public static final Unit<Angle> MINUTE_ANGLE = addUnit(SI.MINUTE_ANGLE);

    public static final Unit<Angle> SECOND_ANGLE = addUnit(SI.SECOND_ANGLE);

    // ////////
    // Area //
    // ////////
    /**
     * A unit of area (standard name <code>sft</code> ).
     */
    public static final Unit<Area> SQUARE_FOOT = addUnit(new ProductUnit<Area>(
	    (AbstractUnit<?>) FOOT.multiply(FOOT)));

    /**
     * A unit of area equal to <code>100 m²</code> (standard name <code>a</code>
     * ).
     */
    public static final Unit<Area> ARE = addUnit(SQUARE_METRE.multiply(100));

    /**
     * A unit of area equal to <code>100 {@link #ARE}</code> (standard name
     * <code>ha</code>).
     */
    public static final Unit<Area> HECTARE = addUnit(ARE.multiply(100)); // Exact.

    /**
     * The acre is a unit of area used in the imperial and U.S. customary
     * systems. It is equivalent to <code>43,560 square feet</code>. An acre is
     * about 40% of a <code>HECTARE</code> – slightly smaller than an American
     * football field. (standard name <code>ac</code> ).
     * 
     * @see <a href="http://en.wikipedia.org/wiki/Acre">Wikipedia: Acre</a>
     */
    public static final Unit<Area> ACRE = addUnit(SQUARE_FOOT.multiply(43560));

    // //////////
    // Volume //
    // //////////
    /**
     * A unit of volume equal to one cubic decimeter (default label
     * <code>L</code>, also recognized <code>µL, mL, cL, dL</code>).
     */
    public static final Unit<Volume> LITER = new TransformedUnit<Volume>(
	    CUBIC_METRE, new RationalConverter(1, 1000));
    // private static final Unit<Volume> LITRE = addUnit(Units.LITRE);

    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<Time> MINUTE = addUnit(Units.MINUTE);
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<Time> HOUR = addUnit(Units.HOUR);
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<Time> DAY = addUnit(Units.DAY);

    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    static final Unit<Time> YEAR_JULIAN = addUnit(Units.DAY
	    .multiply(365.25));
 
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<Time> YEAR = addUnit(Units.DAY.multiply(365.25));
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */

    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<Time> MONTH = addUnit(YEAR_JULIAN.divide(12));

    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    private static final Unit<Pressure> BAR = addUnit(Units.PASCAL
	    .multiply(100000));
    public static final Unit<Mass> GRAM = addUnit(Units.GRAM);

    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<Mass> TONNE = addUnit(Units.KILOGRAM
	    .multiply(1000));

    // ///////////////////////////////
    // NATURAL UNITS                //
    // ///////////////////////////////
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    static final Unit<Speed> C = addUnit(Units.METRES_PER_SECOND
	    .multiply(299792458));
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<Action> PLANCK = addUnit(SI.JOULE_SECOND
	    .multiply(6.6260755E-24)); // FIXME get rid of JXQ import (where
				       // from??) */
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<?> BOLTZMAN = addUnit(JOULE.divide(KELVIN)
	    .multiply(1.380658E-23));
 
    private static final Unit<Acceleration> ACCELLERATION_OF_FREEFALL = addUnit(Units.METRES_PER_SQUARE_SECOND
	    .multiply(9.80665));
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<Pressure> ATMOSPHERE = addUnit(Units.PASCAL
	    .multiply(101325));

    // //////////
    // Length //
    // //////////
    /**
     * A unit of length equal to the distance that light travels in one year
     * through a vacuum (standard name <code>ly</code>).
     */
    public static final Unit<Length> LIGHT_YEAR = addUnit(new ProductUnit<Length>(
	    C.multiply(YEAR_JULIAN)));
    /**
     * A unit of length equal to the distance that light travels in one year
     * through a vacuum (standard name <code>ly</code>).
     */
    // static final Unit<Length> LIGHT_YEAR = addUnit(METRE
    // .multiply(9.460528405e15));

    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    static final Unit<Length> INCH_INTERNATIONAL = addUnit(CENTI(METRE)
	    .multiply(254).divide(100));
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    static final Unit<Length> FOOT_INTERNATIONAL = addUnit(INCH_INTERNATIONAL
	    .multiply(12));
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<Length> NAUTICAL_MILE = addUnit(METRE
	    .multiply(1852));
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<Speed> KNOT = addUnit(new ProductUnit<Speed>(
	    NAUTICAL_MILE.divide(HOUR)));

    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    private static final Unit<Mass> GRAIN = addUnit(MILLI(GRAM).multiply(
	    6479891).divide(100000));
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    static final Unit<Mass> POUND = addUnit(GRAIN.multiply(7000));

    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<Mass> CARAT = addUnit(GRAM.divide(5));
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    private static final Unit<Dimensionless> CARAT_GOLD = addUnit(ONE
	    .divide(24));

    private static final Unit<Force> POUND_FORCE = addUnit(POUND.multiply(
	    ACCELLERATION_OF_FREEFALL).asType(Force.class));

    /**
     * A unit of length equal to the distance at which a star would appear to
     * shift its position by one arcsecond over the course the time (about 3
     * months) in which the Earth moves a distance of {@link #ASTRONOMICAL_UNIT}
     * in the direction perpendicular to the direction to the star (standard
     * name <code>pc</code>).
     */
    private static final Unit<Length> PARSEC = addUnit(METRE
	    .multiply(30856770e9));

    /**
     * A unit of length equal to <code>1/72 {@link #INCH}</code> (standard name
     * <code>pixel</code>). It is the American point rounded to an even 1/72
     * inch.
     * 
     * @see #POINT
     * @deprecated Does not seem to be in CLDR
     */
    static final Unit<Length> PIXEL = addUnit(INCH.divide(72));

    /**
     * Equivalent {@link #PIXEL}
     * 
     * @deprecated Does not seem to be in CLDR
     */
    static final Unit<Length> COMPUTER_POINT = PIXEL;

    // ///////////////////////////////////////////
    // TYPESETTER'S LENGTH UNITS                //
    // ///////////////////////////////////////////
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    static final Unit<Length> LINE = addUnit(INCH_INTERNATIONAL
	    .divide(12));
    /**
     * A unit of length equal to <code>0.013837 {@link #INCH}</code> exactly
     * (standard name <code>pt</code>).
     * 
     * @see #PIXEL
     */
    public static final Unit<Length> POINT = addUnit(LINE.divide(6));
    // static final Unit<Length> POINT = addUnit(INCH.multiply(13837)
    // .divide(1000000));

    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<Length> PICA = addUnit(POINT.multiply(12));
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<Length> POINT_PRINTER = addUnit(INCH_INTERNATIONAL
	    .multiply(13837).divide(1000000));
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<Length> PICA_PRINTER = addUnit(POINT_PRINTER
	    .multiply(12));

    // ////////////////////////////////////
    // OTHER LEGACY UNITS: CLDR         //
    // ////////////////////////////////////
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<Temperature> FAHRENHEIT = addUnit(KELVIN
	    .multiply(5).divide(9).shift(459.67));

    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    private static final Unit<Energy> CALORIE_THERMOCHEMICAL = addUnit(JOULE
	    .multiply(4184).divide(1000));
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<Energy> CALORIE = addUnit(CALORIE_THERMOCHEMICAL);
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    private static final Unit<Energy> CALORIE_FOOD = addUnit(KILO(CALORIE_THERMOCHEMICAL));

    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<Power> HORSEPOWER = addUnit(new ProductUnit<Power>(
	    FOOT_INTERNATIONAL.multiply(POUND_FORCE).divide(SECOND)));

    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<Pressure> POUND_PER_SQUARE_INCH = addUnit(new ProductUnit<Pressure>(
	    POUND_FORCE.divide(INCH_INTERNATIONAL.pow(2))));
    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<Angle> CIRCLE = addUnit(new ProductUnit<Angle>(
	    PI.multiply(RADIAN.multiply(2))));

    /** As per <a href="http//cldr.unicode.org/">CLDR</a> standard. */
    public static final Unit<SolidAngle> SPHERE = addUnit(new ProductUnit<SolidAngle>(
	    PI.multiply(STERADIAN.multiply(4))));

    /**
     * The unit for binary information (standard name <code>bit</code>).
     */
    public static final Unit<Information> BIT = addUnit(
	    new AlternateUnit<Information>(ONE, "bit"), Information.class);

    /**
     * A unit of data amount equal to <code>8 {@link SI#BIT}</code> (BinarY
     * TErm, standard name <code>byte</code>).
     */
    public static final Unit<Information> BYTE = addUnit(BIT.multiply(8));

    /**
     * The unit for binary information rate (standard name
     * <code>bit/s</code>).
     */
    public static final ProductUnit<InformationRate> BITS_PER_SECOND = addUnit(
	    new ProductUnit<InformationRate>(BIT.divide(SECOND)),
	    InformationRate.class);

    /**
     * Equivalent {@link #BYTE}
     */
    static final Unit<Information> OCTET = BYTE;

    // ///////////////////
    // Collection View //
    // ///////////////////

    @Override
    public String getName() {
	return "CLDR";
    }

    /**
     * Adds a new unit not mapped to any specified quantity type.
     *
     * @param unit
     *            the unit being added.
     * @return <code>unit</code>.
     */
    private static <U extends Unit<?>> U addUnit(U unit) {
	INSTANCE.units.add(unit);
	return unit;
    }

    /**
     * Adds a new unit and maps it to the specified quantity type.
     *
     * @param unit
     *            the unit being added.
     * @param type
     *            the quantity type.
     * @return <code>unit</code>.
     */
    private static <U extends AbstractUnit<?>> U addUnit(U unit,
	    Class<? extends Quantity<?>> type) {
	INSTANCE.units.add(unit);
	INSTANCE.quantityToUnit.put(type, unit);
	return unit;
    }

    // //////////////////////////////////////////////////////////////////////////
    // Label adjustments for CLDR system
    static {
	SimpleUnitFormat.getInstance().label(BYTE, "B");
	SimpleUnitFormat.getInstance().label(CARAT_GOLD, "kt");
	SimpleUnitFormat.getInstance().label(CARAT, "ct");
	SimpleUnitFormat.getInstance().label(POUND, "lb");
	SimpleUnitFormat.getInstance().label(BAR, "b");
    }
}