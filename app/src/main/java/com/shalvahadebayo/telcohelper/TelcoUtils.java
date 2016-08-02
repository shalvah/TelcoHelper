package com.shalvahadebayo.telcohelper;

/**
 * Created by J on 20/06/2016.
 */
public class TelcoUtils
	{

		/**
		 * telco names
		 * */
		public static final String TELCO_MTN = "MTN";
		public static final String TELCO_GLO = "Glo";
		public static final String TELCO_AIRTEL = "Airtel";
		public static final String TELCO_ETISALAT = "etisalat";
		public static final String TELCO_NTEL = "nTel";


		//// TODO: 24/06/2016 confirm accuracy of each code below
		/**
		 * possible actions
		 */
		public static final String ACTION_CHECK_AIRTIME_BALANCE = "Check Airtime Balance";
		public static final String ACTION_CHECK_DATA_BALANCE = "Check Data Balance";
		public static final String ACTION_RECHARGE_AIRTIME = "Recharge Airtime";
		public static final String ACTION_CUSTOMER_CARE = "Customer Care";
		public static final String ACTION_PLEASE_CALL_ME = "Please Call Me";
		public static final String ACTION_BORROW_AIRTIME = "Borrow airtime";
		public static final String ACTION_SHOW_NUMBER = "Show My Number";

		/**
		 * MTN codes
		 */
		public static final String MTN_CHECK_AIRTIME = "*556";
		public static final String MTN_CHECK_DATA = "*131*4";
		public static final String MTN_CUSTOMER_CARE = "180";
		public static final String MTN_RECHARGE = "*555*";
		public static final String MTN_CALL_ME = "*133*";
		public static final String MTN_BORROW_AIRTIME = "*606";
		public static final String MTN_SHOW_NUMBER = "*123*1*5";

		/**
		 * GLO codes
		 */
		public static final String GLO_CHECK_AIRTIME = "#124*1";
		public static final String GLO_CHECK_DATA = "*777";
		public static final String GLO_CUSTOMER_CARE = "121";
		public static final String GLO_RECHARGE = "*123*";
		public static final String GLO_CALL_ME = "*125*";
		public static final String GLO_BORROW_AIRTIME = "*321";
		public static final String GLO_SHOW_NUMBER = "*138*8";

		/**
		 * AIRTEL codes
		 */
		public static final String AIRTEL_CHECK_AIRTIME = "*123";
		public static final String AIRTEL_CHECK_DATA = "*141*7";
		public static final String AIRTEL_CUSTOMER_CARE = "121";
		public static final String AIRTEL_RECHARGE = "*126*";
		public static final String AIRTEL_CALL_ME = "*140*";
		public static final String AIRTEL_BORROW_AIRTIME = "*500";
		public static final String AIRTEL_SHOW_NUMBER = "*121*5*1";

		/**
		 * ETISALAT codes
		 */
		public static final String ETISALAT_CHECK_AIRTIME = "*232";
		public static final String ETISALAT_CHECK_DATA = "*228";
		public static final String ETISALAT_CUSTOMER_CARE = "200";
		public static final String ETISALAT_RECHARGE = "*222*";
		public static final String ETISALAT_CALL_ME = "*266*";
		public static final String ETISALAT_BORROW_AIRTIME = "*665*";
		public static final String ETISALAT_SHOW_NUMBER = "*248*";

		/**
		 * NTEL codes
		 */
		public static final String NTEL_CHECK_AIRTIME = "";
		public static final String NTEL_CHECK_DATA = "";
		public static final String NTEL_CUSTOMER_CARE = "";
		public static final String NTEL_RECHARGE = "";
		public static final String NTEL_CALL_ME = "";
		public static final String NTEL_BORROW_AIRTIME = "";
		public static final String NTEL_SHOW_NUMBER = "";


		//given the position of the selected item in the list of actions (actionId)
		//return the action at that position as a String
		public static String getActionAsString(String actionId)
		{
			switch (actionId)
			{
				case "0":
					return ACTION_CHECK_AIRTIME_BALANCE;
				case "1":
					return ACTION_CHECK_DATA_BALANCE;
				case "2":
					return ACTION_RECHARGE_AIRTIME;
				case "3":
					return ACTION_CUSTOMER_CARE;
				case "4":
					return ACTION_PLEASE_CALL_ME;
				case "5":
					return ACTION_BORROW_AIRTIME;
				default:
					return ACTION_SHOW_NUMBER;
			}
		}

		//given the position of the selected item in the list of telcos (telcoId),
		//return the telco at that position as a String
		public static String getTelco(String telcoId)
		{
			switch (telcoId)
			{
				case "0":
					return TELCO_MTN;
				case "1":
					return TELCO_GLO;
				case "2":
					return TELCO_AIRTEL;
				case "3":
					return TELCO_ETISALAT;
				default:
					return TELCO_NTEL;
			}
		}

		//given the selected action and telco ss Strings
		//return the appropriate network code (without concluding '#')
		static String getUssd(String action, String telco)
		{
			switch (action)
			{
				case ACTION_CHECK_AIRTIME_BALANCE:
					switch (telco)
					{
						case TELCO_MTN:
							return MTN_CHECK_AIRTIME;
						case TELCO_GLO:
							return GLO_CHECK_AIRTIME;
						case TELCO_AIRTEL:
							return AIRTEL_CHECK_AIRTIME;
						case TELCO_ETISALAT:
							return ETISALAT_CHECK_AIRTIME;
						default:
							return NTEL_CHECK_AIRTIME;
					}
				case ACTION_CHECK_DATA_BALANCE:
					switch (telco)
					{
						case TELCO_MTN:
							return MTN_CHECK_DATA;
						case TELCO_GLO:
							return GLO_CHECK_DATA;
						case TELCO_AIRTEL:
							return AIRTEL_CHECK_DATA;
						case TELCO_ETISALAT:
							return ETISALAT_CHECK_DATA;
						default:
							return NTEL_CHECK_DATA;
					}
				case ACTION_CUSTOMER_CARE:
					switch (telco)
					{
						case TELCO_MTN:
							return MTN_CUSTOMER_CARE;
						case TELCO_GLO:
							return GLO_CUSTOMER_CARE;
						case TELCO_AIRTEL:
							return AIRTEL_CUSTOMER_CARE;
						case TELCO_ETISALAT:
							return ETISALAT_CUSTOMER_CARE;
						default:
							return NTEL_CUSTOMER_CARE;
					}
				case ACTION_RECHARGE_AIRTIME:
					switch (telco)
					{
						case TELCO_MTN:
							return MTN_RECHARGE;
						case TELCO_GLO:
							return GLO_RECHARGE;
						case TELCO_AIRTEL:
							return AIRTEL_RECHARGE;
						case TELCO_ETISALAT:
							return ETISALAT_RECHARGE;
						default:
							return NTEL_RECHARGE;
					}
				case ACTION_PLEASE_CALL_ME:
					switch (telco)
					{
						case TELCO_MTN:
							return MTN_CALL_ME;
						case TELCO_GLO:
							return GLO_CALL_ME;
						case TELCO_AIRTEL:
							return AIRTEL_CALL_ME;
						case TELCO_ETISALAT:
							return ETISALAT_CALL_ME;
						default:
							return NTEL_CALL_ME;
					}
				case ACTION_BORROW_AIRTIME:
					switch (telco)
					{
						case TELCO_MTN:
							return MTN_BORROW_AIRTIME;
						case TELCO_GLO:
							return GLO_BORROW_AIRTIME;
						case TELCO_AIRTEL:
							return AIRTEL_BORROW_AIRTIME;
						case TELCO_ETISALAT:
							return ETISALAT_BORROW_AIRTIME;
						default:
							return NTEL_BORROW_AIRTIME;
					}
				case ACTION_SHOW_NUMBER:
					switch (telco)
					{
						case TELCO_MTN:
							return MTN_SHOW_NUMBER;
						case TELCO_GLO:
							return GLO_SHOW_NUMBER;
						case TELCO_AIRTEL:
							return AIRTEL_SHOW_NUMBER;
						case TELCO_ETISALAT:
							return ETISALAT_SHOW_NUMBER;
						default:
							return NTEL_SHOW_NUMBER;
					}
					default:
						return "";
				}
			}
	}
