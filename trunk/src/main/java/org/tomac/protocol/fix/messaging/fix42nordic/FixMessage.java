package org.tomac.protocol.fix.messaging.fix42nordic;

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



public abstract class FixMessage extends FixGeneratedBaseMessage
{

	public static boolean IGNORE_CHECKSUM = false;

	private int msgTypeEnd;
	int msgEnd = 0;

	public long checkSum = 0;
	public byte[] beginString;
	public long bodyLength = 0;
	public long msgSeqNum = 0;
	public boolean possDupFlag = false;
	public byte[] senderCompID;
	public byte[] senderSubID;
	public byte[] sendingTime;
	public byte[] targetCompID;
	public byte[] targetSubID;
	public boolean possResend = false;
	public byte[] onBehalfOfCompID;
	public byte[] onBehalfOfSubID;
	public byte[] origSendingTime;
	public byte[] deliverToCompID;
	public byte[] deliverToSubID;
	
	private static byte[] tmpMsgType = new byte[4];
	private static byte[] tmpBeginString = new byte[BEGINSTRING_VALUE.length];

	/**
	 * crackMsgType performs a garbled check on the fix message. 
	 * @param data
	 * @return msgType as an int.
	 * @throws FixSessionException
	 */
	public static int crackMsgType( ByteBuffer buf ) throws FixSessionException, FixGarbledException {
		int startPos;
		int checkSum;
		int msgType = MsgTypes.UNKNOWN_INT;

		try {
		startPos = buf.position();
		if(buf.remaining() < (FixMessageInfo.BEGINSTRING_VALUE_WITH_TAG.length + 1 /* SOH */ + 5 /* 9=00SOH */) )
			throw new FixGarbledException(buf, "Message too short to contain mandatory header tags");

		int begin = buf.position();

		int tagId = FixUtils.getTagId(buf);
		if(tagId != FixTags.BEGINSTRING_INT)
			throw new FixGarbledException(buf, "First tag in FIX message is not BEGINSTRING (8)");

		FixUtils.getTagStringValue(buf, tmpBeginString);
		//now look to get bodyLength field
		tagId = FixUtils.getTagId(buf);
		if(tagId != FixTags.BODYLENGTH_INT)
			throw new FixGarbledException(buf, "Second tag in FIX message is not BODYLENGTH (9)");

		int bodyLength = FixUtils.getTagIntValue(buf);
		if(bodyLength < 0)

			throw new FixGarbledException(buf, "Invalid BODYLENGTH (9) value: " + bodyLength);

		int checkSumBegin = buf.position() + bodyLength; 
		if(checkSumBegin > buf.limit()) 

			throw new FixGarbledException(buf, "Message too short to contain mandatory checksum");

		//FIRST, validate that we got a msgType field
		tagId = FixUtils.getTagId(buf);
		if(tagId != FixTags.MSGTYPE_INT)
			throw new FixGarbledException(buf, "Third tag in FIX message is not MSGTYPE (35)");

		FixUtils.getTagStringValue(buf, tmpMsgType);

		//we should verify that the final tag IS checksum here if we want to
		buf.position(checkSumBegin);
		tagId = FixUtils.getTagId(buf);
		if(tagId != FixTags.CHECKSUM_INT)
			throw new FixGarbledException(buf, "Final tag in FIX message is not CHECKSUM (10)");

		checkSum = FixUtils.getTagIntValue(buf);
		int calculatedCheckSum = FixUtils.computeChecksum(buf, begin, checkSumBegin);
		if(checkSum != calculatedCheckSum && !IGNORE_CHECKSUM)
			throw new FixGarbledException(buf, String.format("Checksum mismatch; calculated: %s is not equal message checksum: %s", calculatedCheckSum, checkSum));

		// finish-up
		buf.flip();

		buf.position(startPos);

		msgType = FixUtils.getMsgTypeTagAsInt(tmpMsgType, Utils.lastIndexTrim(tmpMsgType, (byte)0));

		msgType = FixUtils.crackNasdaqMsgType(msgType, buf);

		} catch (FixSessionException e) {
			throw new FixGarbledException(buf, e.getMessage());
		} catch (NumberFormatException e) {
			throw new FixGarbledException(buf, e.getMessage());
		}

		return msgType;
	}
	public FixMessage() {
		super();

		beginString = new byte[7];
		senderCompID = new byte[12];
		senderSubID = new byte[6];
		sendingTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		targetCompID = new byte[12];
		targetSubID = new byte[20];
		onBehalfOfCompID = new byte[12];
		onBehalfOfSubID = new byte[6];
		origSendingTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		deliverToCompID = new byte[12];
		deliverToSubID = new byte[6];


	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		checkSum = Long.MAX_VALUE;		
		Utils.fill( beginString, (byte)0 );
		bodyLength = Long.MAX_VALUE;		
		msgSeqNum = Long.MAX_VALUE;		
		possDupFlag = false;		
		Utils.fill( senderCompID, (byte)0 );
		Utils.fill( senderSubID, (byte)0 );
		Utils.fill( sendingTime, (byte)0 );
		Utils.fill( targetCompID, (byte)0 );
		Utils.fill( targetSubID, (byte)0 );
		possResend = false;		
		Utils.fill( onBehalfOfCompID, (byte)0 );
		Utils.fill( onBehalfOfSubID, (byte)0 );
		Utils.fill( origSendingTime, (byte)0 );
		Utils.fill( deliverToCompID, (byte)0 );
		Utils.fill( deliverToSubID, (byte)0 );
	}

	/**
	 * getAll performs stateless session level message validations. Throws a FixSessionException if this fails 
	 */
	@Override
	public void getAll() throws FixSessionException, FixGarbledException
	{

		startPos = buf.position();
		if(buf.remaining() < (FixMessageInfo.BEGINSTRING_VALUE_WITH_TAG.length + 1 /* SOH */ + 5 /* 9=00SOH */) )
			throw new FixGarbledException(buf, "Message too short to contain mandatory header tags");

		int begin = buf.position();

		int tagId = FixUtils.getTagId(buf);
		if(tagId != FixTags.BEGINSTRING_INT)
			throw new FixGarbledException(buf, "First tag in FIX message is not BEGINSTRING (8)");

		FixUtils.getTagStringValue(buf, tmpBeginString);
		if(!Utils.equals(FixMessageInfo.BEGINSTRING_VALUE, tmpBeginString))
			throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("BeginString not equal to: " + new String(FixMessageInfo.BEGINSTRING_VALUE)).getBytes(), FixTags.BEGINSTRING_INT, new byte[0]);		//now look to get bodyLength field
		tagId = FixUtils.getTagId(buf);
		if(tagId != FixTags.BODYLENGTH_INT)
			throw new FixGarbledException(buf, "Second tag in FIX message is not BODYLENGTH (9)");

		int bodyLength = FixUtils.getTagIntValue(buf);
		if(bodyLength < 0)

			throw new FixGarbledException(buf, "Invalid BODYLENGTH (9) value: " + bodyLength);

		int checkSumBegin = buf.position() + bodyLength; 
		if(checkSumBegin > buf.limit()) 

			throw new FixGarbledException(buf, "Message too short to contain mandatory checksum");

		//FIRST, validate that we got a msgType field
		tagId = FixUtils.getTagId(buf);
		if(tagId != FixTags.MSGTYPE_INT)
			throw new FixGarbledException(buf, "Third tag in FIX message is not MSGTYPE (35)");

		FixUtils.getTagStringValue(buf, tmpMsgType);

		msgTypeEnd = buf.position();

		//we should verify that the final tag IS checksum here if we want to
		buf.position(checkSumBegin);
		tagId = FixUtils.getTagId(buf);
		if(tagId != FixTags.CHECKSUM_INT)
			throw new FixGarbledException(buf, "Final tag in FIX message is not CHECKSUM (10)");

		checkSum = FixUtils.getTagIntValue(buf);
		int calculatedCheckSum = FixUtils.computeChecksum(buf, begin, checkSumBegin);
		if(checkSum != calculatedCheckSum && !IGNORE_CHECKSUM)
			throw new FixGarbledException(buf, String.format("Checksum mismatch; calculated: %s is not equal message checksum: %s", calculatedCheckSum, checkSum));

		// finish-up
		buf.position(startPos);

		msgType = FixUtils.getMsgTypeTagAsInt(tmpMsgType, Utils.lastIndexTrim(tmpMsgType, (byte)0));

		msgType = FixUtils.crackNasdaqMsgType(msgType, buf);

		if (! MsgType.isValid(tmpMsgType))
			throw new FixSessionException(SessionRejectReason.INVALID_MSGTYPE, "MsgType not in specificaton for tag".getBytes(), FixTags.MSGTYPE_INT, FixUtils.getMsgType(msgType) );		// assumption message is full otherwise decode would return null
		// so negative id means that we are at the end of the message
		int id;
		buf.position(msgTypeEnd);
		int lastTagPosition = msgTypeEnd;
		while ( ( id = FixUtils.getTagId( buf ) ) > 0 )
		{
			ByteBuffer value;

			value = buf;

			switch( id ) {

			case FixTags.MSGSEQNUM_INT:
				msgSeqNum = FixUtils.getTagIntValue( value );
				break;

			case FixTags.POSSDUPFLAG_INT:
				possDupFlag = FixUtils.getTagBooleanValue( value );
				break;

			case FixTags.SENDERCOMPID_INT:
				senderCompID = FixUtils.getTagStringValue(value, senderCompID);
				break;

			case FixTags.SENDERSUBID_INT:
				senderSubID = FixUtils.getTagStringValue(value, senderSubID);
				break;

			case FixTags.SENDINGTIME_INT:
				sendingTime = FixUtils.getTagStringValue(value, sendingTime);
				break;

			case FixTags.TARGETCOMPID_INT:
				targetCompID = FixUtils.getTagStringValue(value, targetCompID);
				break;

			case FixTags.TARGETSUBID_INT:
				targetSubID = FixUtils.getTagStringValue(value, targetSubID);
				break;

			case FixTags.POSSRESEND_INT:
				possResend = FixUtils.getTagBooleanValue( value );
				break;

			case FixTags.ONBEHALFOFCOMPID_INT:
				onBehalfOfCompID = FixUtils.getTagStringValue(value, onBehalfOfCompID);
				break;

			case FixTags.ONBEHALFOFSUBID_INT:
				onBehalfOfSubID = FixUtils.getTagStringValue(value, onBehalfOfSubID);
				break;

			case FixTags.ORIGSENDINGTIME_INT:
				origSendingTime = FixUtils.getTagStringValue(value, origSendingTime);
				break;

			case FixTags.DELIVERTOCOMPID_INT:
				deliverToCompID = FixUtils.getTagStringValue(value, deliverToCompID);
				break;

			case FixTags.DELIVERTOSUBID_INT:
				deliverToSubID = FixUtils.getTagStringValue(value, deliverToSubID);
				break;

			default:
				buf.position( lastTagPosition );

				return;

			}

			lastTagPosition = buf.position();

		}
	}

	/**
	 * @return the length written
	 *
	 */
	@Override
	public abstract void encode( ByteBuffer out );

	@Override
	public abstract void printBuffer( ByteBuffer out );

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixMessage)) return false;

			FixMessage msg = (FixMessage) o;

		if (!Utils.equals( beginString, msg.beginString)) return false;

		if (!( msgSeqNum==msg.msgSeqNum)) return false;

		if (!( possDupFlag==msg.possDupFlag)) return false;

		if (!Utils.equals( senderCompID, msg.senderCompID)) return false;

		if (!Utils.equals( senderSubID, msg.senderSubID)) return false;

		if (!Utils.equals( targetCompID, msg.targetCompID)) return false;

		if (!Utils.equals( targetSubID, msg.targetSubID)) return false;

		if (!( possResend==msg.possResend)) return false;

		if (!Utils.equals( onBehalfOfCompID, msg.onBehalfOfCompID)) return false;

		if (!Utils.equals( onBehalfOfSubID, msg.onBehalfOfSubID)) return false;

		if (!Utils.equals( deliverToCompID, msg.deliverToCompID)) return false;

		if (!Utils.equals( deliverToSubID, msg.deliverToSubID)) return false;

		return true;

	}

	@Override
	public abstract String toString();
}
