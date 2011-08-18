package org.tomac.protocol.fix.messaging.fix50sp2.component;

// DO NOT EDIT!!!
// This file is generated by FixMessageGenerator.
// If you need additional functionality, put it in a helper class
// that does not live in this folder!!!  Any java file in this folder 
// will be deleted upon the next run of the FixMessageGenerator!

import java.nio.ByteBuffer;

import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.FixSessionException;
import org.tomac.protocol.fix.FixGarbledException;
import org.tomac.utils.Utils;
import org.tomac.protocol.fix.FixConstants;


import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo.*;
import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;

public class FixTickRules
{

	public int noTickRules;
	public TickRules[] group;

	public void getAll(int noTickRules, ByteBuffer buf) throws FixSessionException {
		this.noTickRules = noTickRules;

		if (noTickRules < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group.length < noTickRules) 
			group = new TickRules[noTickRules];

		for ( int i = 0; i < noTickRules; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noTickRules; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noTickRules; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noTickRules; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noTickRules; i++)
			s += group[i].toString();
		return s;
	}

public class TickRules implements FixComponent
{

	public long startTickPriceRange = 0;
	public long endTickPriceRange = 0;
	public long tickIncrement = 0;
	public long tickRuleType = 0;

	public TickRules() {
		super();

		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		startTickPriceRange = Long.MAX_VALUE;		
		endTickPriceRange = Long.MAX_VALUE;		
		tickIncrement = Long.MAX_VALUE;		
		tickRuleType = Long.MAX_VALUE;		
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.STARTTICKPRICERANGE_INT) {
				startTickPriceRange = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ENDTICKPRICERANGE_INT) {
				endTickPriceRange = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.TICKINCREMENT_INT) {
				tickIncrement = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.TICKRULETYPE_INT) {
				tickRuleType = FixUtils.getTagIntValue( value );
				if (!TickRuleType.isValid(tickRuleType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + tickRuleType + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			id = checkRequiredTags();
			if (id > 0) throw new FixSessionException(buf, "Required tag missing: " + id );

			buf.position( lastTagPosition );
			return;

	}

	private int checkRequiredTags() {
		int tag = -1;

		return tag;

	}
	@Override
	public boolean isSet()
	{
		if (FixUtils.isSet(startTickPriceRange)) return true;
		if (FixUtils.isSet(endTickPriceRange)) return true;
		if (FixUtils.isSet(tickIncrement)) return true;
		if (FixUtils.isSet(tickRuleType)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(startTickPriceRange)) FixUtils.putFixFloatTag( out, FixTags.STARTTICKPRICERANGE_INT, startTickPriceRange);
		if (FixUtils.isSet(endTickPriceRange)) FixUtils.putFixFloatTag( out, FixTags.ENDTICKPRICERANGE_INT, endTickPriceRange);
		if (FixUtils.isSet(tickIncrement)) FixUtils.putFixFloatTag( out, FixTags.TICKINCREMENT_INT, tickIncrement);
		if (FixUtils.isSet(tickRuleType)) FixUtils.putFixTag( out, FixTags.TICKRULETYPE_INT, tickRuleType);
	}
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will end up in nifelheim!
	**/
	@Override
	public String toString() {
		char sep = '\n';
		if (Boolean.getBoolean("fix.useOneLiner")) sep = ( byte )0x01;

		String s = "";

			if (FixUtils.isSet(startTickPriceRange)) s += "StartTickPriceRange(1206)=" + String.valueOf(startTickPriceRange) + sep;
			if (FixUtils.isSet(endTickPriceRange)) s += "EndTickPriceRange(1207)=" + String.valueOf(endTickPriceRange) + sep;
			if (FixUtils.isSet(tickIncrement)) s += "TickIncrement(1208)=" + String.valueOf(tickIncrement) + sep;
			if (FixUtils.isSet(tickRuleType)) s += "TickRuleType(1209)=" + String.valueOf(tickRuleType) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof TickRules)) return false;

			TickRules msg = (TickRules) o;

		if ( ! super.equals(msg) ) return false;

		if (!( startTickPriceRange==msg.startTickPriceRange)) return false;

		if (!( endTickPriceRange==msg.endTickPriceRange)) return false;

		if (!( tickIncrement==msg.tickIncrement)) return false;

		if (!( tickRuleType==msg.tickRuleType)) return false;

		return true;
	}
}
}
