package com.queens.amber.fragments

class HistoryFragment : Fragment() {

    private lateinit var dbHelper: HospitalDbHelper

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dbHelper = HospitalDbHelper(requireContext())

//test hopital
        val values = ContentValues().apply {
            put(COLUMN_NAME, "Hopital Hotel Dieu")
            put(COLUMN_ADDRESS, "0000 Monot St.")
            put(COLUMN_PHONE, "01421000")
            put(COLUMN_EMAIL, "hoteldieu@usj.edu.lb")
        }
        val newRowId = db.insert(TABLE_HOSPITALS, null, values)


        val projection = arrayOf(COLUMN_ID, COLUMN_NAME, COLUMN_ADDRESS, COLUMN_PHONE, COLUMN_EMAIL)
        val cursor = db.query(
            TABLE_HOSPITALS,
            projection,
            null,
            null,
            null,
            null,
            null
        )

        val hospitals = mutableListOf<Hospital>()
        with(cursor) {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(COLUMN_ID))
                val name = getString(getColumnIndexOrThrow(COLUMN_NAME))
                val address = getString(getColumnIndexOrThrow(COLUMN_ADDRESS))
                val phone = getString(getColumnIndexOrThrow(COLUMN_PHONE))
                val email = getString(getColumnIndexOrThrow(COLUMN_EMAIL))
                hospitals.add(Hospital(id, name, address, phone, email))
            }
        }




