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


import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo;
import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;

public class FixExecInstRules
{

	public int noExecInstRules;
	public ExecInstRules[] group;

	public void getAll(int noExecInstRules, ByteBuffer buf) throws FixSessionException {
		this.noExecInstRules = noExecInstRules;

		if (noExecInstRules < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group.length < noExecInstRules) 
			group = new ExecInstRules[noExecInstRules];

		for ( int i = 0; i < noExecInstRules; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noExecInstRules; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noExecInstRules; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noExecInstRules; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noExecInstRules; i++)
			s += group[i].toString();
		return s;
	}

public class ExecInstRules implements FixComponent
{

	public byte execInstValue = (byte)' ';

	public ExecInstRules() {
		super();

		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		execInstValue = Byte.MAX_VALUE;		
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.EXECINSTVALUE_INT) {
				execInstValue = FixUtils.getTagCharValue( value );
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
		if (FixUtils.isSet(execInstValue)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(execInstValue)) FixUtils.putFixTag( out, FixTags.EXECINSTVALUE_INT, execInstValue );
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

			if (FixUtils.isSet(execInstValue)) s += "ExecInstValue(1308)=" + String.valueOf(execInstValue) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof ExecInstRules)) return false;

			ExecInstRules msg = (ExecInstRules) o;

		if ( ! super.equals(msg) ) return false;

		if (!( execInstValue==msg.execInstValue)) return false;

		return true;
	}
}
}
