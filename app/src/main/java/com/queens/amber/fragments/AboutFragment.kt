package com.queens.amber.fragments


class AboutFragment : Fragment() {

    private lateinit var appNameTextView: TextView
    private lateinit var appVersionTextView: TextView
    private lateinit var descriptionTextView: TextView
    val retrofit = Retrofit.Builder()
                .baseUrl("http://24875748329755858.mock-api.com/about")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    val service = retrofit.create(AboutService::class.java)
    val call = service.getAboutInfo()
    call.enqueue(object : Callback<About> {
        override fun onResponse(call: Call<About>, response: Response<About>) {
            val about = response.body()
        }

            override fun onCreateView(
                inflater: LayoutInflater,
                container: ViewGroup?,
                savedInstanceState: Bundle?
            ): View? {
                // Inflate the layout for this fragment
                val view = inflater.inflate(R.layout.fragment_about, container, false)
                appNameTextView = view.findViewById(R.id.text_view_app_name)
                appVersionTextView = view.findViewById(R.id.text_view_app_version)
                descriptionTextView = view.findViewById(R.id.text_view_description)
                return view
            }

            override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                super.onViewCreated



